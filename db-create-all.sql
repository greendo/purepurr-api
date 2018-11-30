create table video (
  id                            bigint auto_increment not null,
  video_name                    varchar(50),
  packet_id                     integer,
  version                       bigint not null,
  created_on                    datetime(6) not null,
  modified_on                   datetime(6) not null,
  constraint pk_video primary key (id)
);

