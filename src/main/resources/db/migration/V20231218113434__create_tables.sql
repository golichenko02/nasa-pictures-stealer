create table cameras
(
    id         bigserial primary key,
    nasa_id    bigint unique not null,
    name       text          not null,
    created_at timestamp     not null default now()
);

create table pictures
(
    id         bigserial primary key,
    nasa_id    bigint unique not null,
    img_src    text          not null,
    camera_id  bigint references cameras,
    created_at timestamp default now()
)