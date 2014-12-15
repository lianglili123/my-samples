package my.sample.helloworld.dao;

import java.util.List;

import my.sample.helloworld.entities.Writer;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("writerDao")
public class WriterDaoImpl implements WriterDao {

	@Autowired
	private SessionFactory sessionFactory;

	public WriterDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public WriterDaoImpl() {
	};

	@Override
	@Transactional
	public Writer getWriter(int id) {

		return (Writer) sessionFactory.getCurrentSession()
				.get(Writer.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Writer> getWriterList() {
		return (List<Writer>) sessionFactory.getCurrentSession()
				.createCriteria(Writer.class).list();
	}

}
