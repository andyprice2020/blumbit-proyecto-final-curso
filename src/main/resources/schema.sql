/* Table Artist */
CREATE TABLE store.artists (
    artist_id uuid PRIMARY KEY DEFAULT uuid_generate_v4() UNIQUE NOT NULL,
    "name" varchar(400) NULL,
    enabled bool NOT NULL DEFAULT TRUE,
    created_by_user varchar(50) NOT NULL,
    created_date timestamp NOT NULL,
    last_modified_date timestamp NOT NULL,
    last_modified_by_user varchar(50) NOT NULL,
    count_modified int8 NULL
);

/* Table Albums */
CREATE TABLE store.albums (
    album_id uuid PRIMARY KEY DEFAULT uuid_generate_v4() UNIQUE NOT NULL,
    artist_id uuid references store.artists(artist_id),
    title varchar(200) NULL,
    enabled bool NOT NULL DEFAULT TRUE,
    created_by_user varchar(50) NOT NULL,
    created_date timestamp NOT NULL,
    last_modified_date timestamp NOT NULL,
    last_modified_by_user varchar(50) NOT NULL,
    count_modified int8 NULL
);

/* Table Employee*/
CREATE TABLE store.employees (

    employee_id uuid PRIMARY KEY DEFAULT uuid_generate_v4() UNIQUE NOT NULL,
    last_name varchar(45) NULL,
    first_name varchar(45) NULL,
    title varchar(30) NULL,
    reports_to varchar(80) NULL,
    birth_date timestamp NULL,
    hire_date timestamp NULL,
    address varchar(200) NULL,
    city varchar(80) NULL,
    state varchar(80) NULL,
    country varchar(80) NULL,
    postal_code varchar(20) NULL,
    phone varchar(30) NULL,
    fax varchar(30) NULL,
    email varchar(80) NULL,
    enabled bool NOT NULL DEFAULT TRUE,
    created_by_user varchar(50) NOT NULL,
    created_date timestamp NOT NULL,
    last_modified_by_user varchar(50) NOT NULL,
    last_modified_date timestamp NOT NULL,
    count_modified int8 NULL
);

/* Table Customer */
CREATE TABLE store.customers (
    customer_id uuid PRIMARY KEY DEFAULT uuid_generate_v4() UNIQUE NOT NULL,
    first_name varchar(45) NULL,
    last_name varchar(45) NULL,
    company varchar(200) NULL,
    address varchar(200) NULL,
    city varchar(80) NULL,
    state varchar(80) NULL,
    country varchar(80) NULL,
    postal_code varchar(20) NULL,
    phone varchar(30) NULL,
    fax varchar(30) NULL,
    email varchar(80) NULL,
    support_rep_id uuid REFERENCES store.employees(employee_id),
    enabled bool NOT NULL DEFAULT TRUE,
    created_by_user varchar(50) NOT NULL,
    created_date timestamp NOT NULL,
    last_modified_by_user varchar(50) NOT NULL,
    last_modified_date timestamp NOT NULL,
    count_modified int8 NULL
);

/* Table Genre*/
CREATE TABLE store.genres (
    genre_id uuid PRIMARY KEY DEFAULT uuid_generate_v4() UNIQUE NOT NULL,
    "name" varchar(40) NULL,
    enabled bool NOT NULL DEFAULT TRUE,
    created_by_user varchar(50) NOT NULL,
    created_date timestamp NOT NULL,
    last_modified_by_user varchar(50) NOT NULL,
    last_modified_date timestamp NOT NULL,
    count_modified int8 NULL
);

/* Table Invoice */
CREATE TABLE store.invoices (
    invoice_id uuid PRIMARY KEY DEFAULT uuid_generate_v4() UNIQUE NOT NULL,
    customer_id uuid REFERENCES store.customers(customer_id),
    invoice_date timestamp NULL,
    billing_address varchar(200) NULL,
    billing_city varchar(80) NULL,
    billing_state varchar(80) NULL,
    billing_country varchar(80) NULL,
    billing_postal_code varchar(20) NULL,
    total numeric(38, 2) NULL,
    enabled bool NOT NULL DEFAULT TRUE,
    created_by_user varchar(50) NOT NULL,
    created_date timestamp NOT NULL,
    last_modified_by_user varchar(50) NOT NULL,
    last_modified_date timestamp NOT NULL,
    count_modified int8 NULL
);

/* Table Media Type*/
CREATE TABLE store.media_types (
    media_type_id uuid PRIMARY KEY DEFAULT uuid_generate_v4() UNIQUE NOT NULL,
    "name" varchar(80) NULL,
    enabled bool NOT NULL DEFAULT TRUE,
    created_by_user varchar(50) NOT NULL,
    created_date timestamp NOT NULL,
    last_modified_by_user varchar(50) NOT NULL,
    last_modified_date timestamp NOT NULL,
    count_modified int8 NULL
);

/* Table Track */
CREATE TABLE store.tracks (
    track_id uuid PRIMARY KEY DEFAULT uuid_generate_v4() UNIQUE NOT NULL,
    "name" varchar(80) NOT NULL,
    album_id uuid REFERENCES store.albums(album_id),
    genre_id uuid REFERENCES store.genres(genre_id),
    media_type_id uuid REFERENCES store.media_types(media_type_id),
    composer varchar(80) NULL,
    milliseconds int4 NOT NULL,
    bytes int4 NULL,
    unit_price numeric(38, 2) NOT NULL,
    enabled bool NOT NULL DEFAULT TRUE,
    created_by_user varchar(50) NOT NULL,
    created_date timestamp NOT NULL,
    last_modified_by_user varchar(50) NOT NULL,
    last_modified_date timestamp NOT NULL,
    count_modified int8 NULL
);

/* Table InvoiceLine */
CREATE TABLE store.invoice_lines (
    invoiceline_id uuid PRIMARY KEY DEFAULT uuid_generate_v4() UNIQUE NOT NULL,
    invoice_id uuid REFERENCES store.invoices(invoice_id),
    track_id uuid REFERENCES store.tracks(track_id),
    unit_price numeric(38, 2) NULL,
    quantity numeric(38, 2) NULL,
    enabled bool NOT NULL DEFAULT TRUE,
    created_by_user varchar(50) NOT NULL,
    created_date timestamp NOT NULL,
    last_modified_by_user varchar(50) NOT NULL,
    last_modified_date timestamp NOT NULL,
    count_modified int8 NULL
);

/* Table Playlist */
CREATE TABLE store.playlists (
    playlist_id uuid PRIMARY KEY DEFAULT uuid_generate_v4() UNIQUE NOT NULL,
    "name" varchar(80) NULL,
    enabled bool NOT NULL DEFAULT TRUE,
    created_by_user varchar(50) NOT NULL,
    created_date timestamp NOT NULL,
    last_modified_by_user varchar(50) NOT NULL,
    last_modified_date timestamp NOT NULL,
    count_modified int8 NULL
);

/* Table PlaylistTracks*/
CREATE TABLE store.playlist_tracks(
    track_id uuid REFERENCES store.tracks(track_id),
    playlist_id uuid REFERENCES store.playlists(playlist_id)
);
