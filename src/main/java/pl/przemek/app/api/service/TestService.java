package pl.przemek.app.api.service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.przemek.app.api.utils.TestBuilder;

@Service
public class TestService {
    @Autowired
    static AmazonDynamoDB amazonDynamoDB;
    static DynamoDB dynamoDB = new DynamoDB(amazonDynamoDB);
    private Table table = dynamoDB.getTable("TestModel");



    public void newModel(String content) {
            Item item = new Item()
                    .withString("Content", content)
                    .withLong("Number", TestBuilder.numberBuilder(1, 1000));
            table.putItem(item);
    }

    public void pullModel(Long id) {
        Item item = table.getItem().withPrimaryKey("Id", id);
        if (item != null) {
            DeleteItemSpec spec = new DeleteItemSpec().withPrimaryKey("Id", id);
            table.deleteItem(spec);
        }
    }
}
