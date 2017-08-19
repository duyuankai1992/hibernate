package com.yztc.demo.util;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class HibernateHBMTool {

	public static void main(String[] args) {		
		//½âÎöÅäÖÃÎÄ¼ş
		Configuration configuration = new Configuration().configure();		
		SchemaExport exp = new SchemaExport(configuration);		
		exp.create(true, true);	
	}
}
