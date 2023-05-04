# Library Management System

## Setup

After cloning the repository you need to run the database server. To do so, run the following command:

```bash
docker-compose up -d
```

This will start the database server on port 5432. You can connect to it using the following credentials:

- Username: postgres
- Password: postgres

In order to make the management easier you can go to http://localhost:5050/
and login inside the pgAdmin4 container using the following credentials:

- Email: admin@mail.com
- Password: SecretPass123

Once you are logged in, you can create a new server connection using the following credentials:

- Host name/address: db
- Port: 5432
- Username: postgres
- Password: postgres
- Maintenance database: postgres