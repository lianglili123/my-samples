package my.sample.helloworld.dao;

import java.util.List;

import my.sample.helloworld.entities.Writer;

public interface WriterDao {

	public Writer getWriter(int id);

	public List<Writer> getWriterList();
}
