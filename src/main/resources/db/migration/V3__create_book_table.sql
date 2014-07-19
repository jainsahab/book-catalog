CREATE TABLE book(
  id INT PRIMARY KEY AUTO_INCREMENT,
  title char(50),
  author_id INT ,
  publisher_id INT, 
  CONSTRAINT FK_author_id FOREIGN KEY (author_id) REFERENCES author(id),
  CONSTRAINT FK_publisher_id FOREIGN KEY (publisher_id)REFERENCES publisher(id)
)