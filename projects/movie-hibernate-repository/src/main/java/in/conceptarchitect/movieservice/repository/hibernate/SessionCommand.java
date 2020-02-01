package in.conceptarchitect.movieservice.repository.hibernate;

import org.hibernate.Session;

public interface SessionCommand {
	void execute(Session session);
}
