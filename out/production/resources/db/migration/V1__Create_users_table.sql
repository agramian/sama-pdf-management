create or replace function set_updated_at() returns trigger as $$
    begin
      new.updated_at = now() at time zone 'utc';
      return new;
    end;
$$ language plpgsql;

create table users (
    id                          uuid        primary key,
    email                       text        not null unique,
    created_at                  timestamptz not null default (now() at time zone 'utc'),
    updated_at                  timestamptz not null default (now() at time zone 'utc'),
    email_verified              bool        not null default false,
    email_verification_nonce    uuid        not null
);

create trigger set_updated_at_on_users
    before update
    on users
    for each row
    execute procedure set_updated_at();
