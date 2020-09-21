package hw8;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hw8.beans.MetalsColorsData;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class DataProviders {

    public static final String path = "src\\test\\resources\\hw8\\JDI_ex8_metalsColorsDataSet.json";

    @DataProvider(name = "testDataset")
    public Object[] getData() {
        Map<String, MetalsColorsData> dataMap = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            dataMap = mapper.readValue(new File(path), new TypeReference<Map<String, MetalsColorsData>>() {});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataMap.values().toArray();
    }
}
