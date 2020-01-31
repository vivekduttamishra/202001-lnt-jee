package in.conceptarchitect.movies.repository.flatfile;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jdk.jfr.Label;

@Component()
@Scope("prototype")
public class FlatFileUserRepository {

	public FlatFileUserRepository() {
		System.out.println("User Repository Created : "+hashCode());
	}
	
}
