package in.conceptarchitect.movieservice;

import java.util.Collection;

public interface Repository<Entity,Id> {

	Id add(Entity entity);
	Collection<Entity> getAll();
	Entity getById(Id id);
	void remove(Id id);
	void update(Id id , Entity newEntity);
	void save();
	
}

// I can have different implementations for
// Jdbc
// Hibernate
// NoSql
// Cloud


