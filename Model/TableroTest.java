package Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TableroTest {

	@Test
	void TesteCombinable() {
		Tablero tablero = new Tablero();
		int a=0;
		int b=2;
		Assert.assertFalse(tablero.esCombinable(a, b));
	}
	
}