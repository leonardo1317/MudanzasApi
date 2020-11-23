CREATE TABLE participants (
  id SERIAL,
  participant_id VARCHAR (15) NOT NULL,
  trace TEXT NOT NULL,
  createdate BIGINT NOT NULL,
  PRIMARY KEY (id)
 );