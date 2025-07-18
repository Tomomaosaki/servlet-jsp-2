--
-- データベース example
--

CREATE TABLE members (
  id       INT          PRIMARY KEY AUTO_INCREMENT,
  name     VARCHAR(100) NOT NULL,
  birthday DATE         NOT NULL
);

INSERT INTO members (name, birthday) VALUES
('湊 雄輔',     '2002-3-12'),
('綾部 みゆき', '2003-4-13');

