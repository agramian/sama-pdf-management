# Email resources

This directory contains emails which are sent by the application.
Each email should be placed in it's own directory containing the following files:

| Required? | Filename    | Purpose |
| --------- | ----------- | ------- |
| no        | README.md   | Describe the email and configuration |
| yes       | body.txt    | Plain text version of email |
| yes       | body.html   | HTML version of email |
| yes       | config.json | Interpolation values and overrides |

### Reserved interpolation values

| Value              | Use |
| ------------------ |:---:|
| styles             | Common styles |
| header_plain_text  | Header plain text |
| body_plain_text    | Body plain text |
| footer_plain_text  | Footer plain text |
| header_html        | Header html |
| body_html          | Body html |
| footer_html        | Footer html |
| company_address    | Company address |
| year               | Year |
| user_email         | User's email |

### JSON email configuration
| Required?  | Key        | Default                   | Value |
| ---------- | ---------- | ------------------------- | -----
| yes        | subject    | N/A                       | Email subject |
| no         | from       | default in Constants.java | Email sender address |

Make sure email-specific interpolation values do not clash with any of these reserved values when drafting an email.
