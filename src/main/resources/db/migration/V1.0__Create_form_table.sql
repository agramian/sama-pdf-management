create or replace function set_updated_at() returns trigger as $$
    begin
      new.updated_at = now() at time zone 'utc';
      return new;
    end;
$$ language plpgsql;

create table form (
    id                          serial      primary key,
    created_at                  timestamptz not null default (now() at time zone 'utc'),
    updated_at                  timestamptz not null default (now() at time zone 'utc'),
    pdf_file_path               text        not null,
    state                       text        not null,
    payer_id                    int         not null,
    plan_id                     int,
    medication_id               int,
    form_config                 json,
    form_element_config         json,
    form_field_config           json
);

create trigger set_updated_at_on_form
    before update
    on form
    for each row
    execute procedure set_updated_at();
