
import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.validator.messageinterpolation.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.hibernate.validator.internal.properties.javabean.*;
import static org.junit.Assert.assertEquals;
import bswanepo.Model.PlayerInfo;
import bswanepo.Model.characterMethods.SelectHero;

public class testValidHeroes {
    private ArrayList<String> hero ;
    private static Validator validator;
    

   @BeforeClass
   public static void setUp() {
      ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
      validator = factory.getValidator();
   }

   @Test
   public void manufacturerIsNull() {
       hero = SelectHero.selectHero("i");
       
    PlayerInfo player = new PlayerInfo(hero.get(0),hero.get(1),hero.get(2),hero.get(3),hero.get(4),hero.get(5),hero.get(6),hero.get(7),hero.get(8),hero.get(9));

      Set<ConstraintViolation<PlayerInfo>> constraintViolations =
              validator.validate( player );

    //   assertEquals( 1, constraintViolations.size() );
    //   assertEquals( "must not be null", constraintViolations.iterator().next().getMessage() );
  }
}
