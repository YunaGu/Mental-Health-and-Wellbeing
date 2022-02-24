-- auto-generated definition
create table news_content
(
    id         int auto_increment
        primary key,
    title      varchar(255) not null,
    authorname varchar(50)  not null,
    image      varchar(255) null,
    text       varchar(255) null,
    state      int          null,
    uploadTime datetime     null,
    deleteTime datetime     null
);

