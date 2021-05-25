import mathDefinitions.model.Def;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class DefinitionLoadTest {

    @Test

    public void loadTest() throws IOException {
        Assertions.assertEquals(0, Def.definitions.size());
        Def.betoltes("/Test/test.xml");
        Assertions.assertEquals(3, Def.definitions.size());
    }

}
