package me.gotdo.vp3.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import com.mongodb.Mongo;

@Configuration
public class SpringMongoConfig extends AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {
		return "ventureprime";
	}

	@Override
	public Mongo mongo() throws Exception {
		return new Mongo("localhost");
	}

}
