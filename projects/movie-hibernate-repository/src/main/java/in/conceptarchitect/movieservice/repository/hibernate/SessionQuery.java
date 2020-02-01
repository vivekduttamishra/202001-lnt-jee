package in.conceptarchitect.movieservice.repository.hibernate;

import java.util.List;

public interface SessionQuery<T> {
	
	List<T> query(String qry);
}
