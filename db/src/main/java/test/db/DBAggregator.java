package test.db;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

import test.db.xml.output.AssetList;
import test.db.xml.output.OutputData;
import test.db.xml.input.InputData;

import java.util.Map;
import java.util.List;

public class DBAggregator implements AggregationStrategy {

	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		// TODO Auto-generated method stub
		
		String firstTime = (String) oldExchange.getIn().getHeader("firstTime");
		
		// Using the firstTime header to determine which aggregation to perform
		if (firstTime.equals("true")) {
			
			// Get the input data object - Unmarshalled in the route from the XML incoming message to JAXB test.db.xml.input.InputData
			
			InputData input = (InputData) oldExchange.getIn().getBody();
			
			// Start constructing the output data JAXB object using test.db.xml.output.OutputData
			
			OutputData output = new OutputData();
			
			int inputNumber = new Integer(oldExchange.getIn().getHeader("inputNumber").toString()).intValue();
			
			// Set values coming from the input xml document
			output.setOutputNumber(inputNumber);
			output.setOutputTime(input.getInputTime());
			
			
			// Get refdescription from SQL Query in direct route getReference - since this is only one row, and one column it's getting it from the header
			output.setReference(newExchange.getIn().getHeader("refdescription").toString());
			
			// Ensure that this phase of the aggregation is complete
			newExchange.getIn().setHeader("firstTime", "false");
			
			// store the output so far into the Message body
			newExchange.getIn().setBody(output);
		}
		else {
			// get partly constructed output ready to enrich with data retrived from route getAsset
			OutputData output = (OutputData) oldExchange.getIn().getBody();
			// Create asset list from SQL result
			
			// Get the SQL result set from the new exchange - create by the route getAsset - this resultset contains multiple rows, and 2 columns
			List <Map<String, Object>> rows = newExchange.getIn().getBody(List.class);
			
			// process the rows and store in the output xml
			for (Map<String, Object> row : rows) {
				
				Integer ai = new Integer (row.get("assetid").toString());
				String assetdescription = (row.get("assetdescription").toString());
				
				AssetList al = new AssetList();
				al.setAssetid(ai.intValue());
				al.setAssetDescription(assetdescription);
				output.getAssets().add(al);
			} 
		
			newExchange.getIn().setBody(output);
		}
		
		return newExchange;
	}

}
