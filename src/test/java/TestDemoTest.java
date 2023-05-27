import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


class TestDemoTest {
	
	private TestDemo testDemo; 

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		
		
		if(!expectException) {
			assertThatThrownBy(() -> 
		    testDemo.addPositive(a, b))
		        .isInstanceOf(IllegalArgumentException.class);

			} 
		else {assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
			
		}

	}
	
	static Stream<Arguments> argumentsForAddPositive(){
		return Stream.of(
                arguments(2, 4, 6, false),
                arguments(0, 5, 0, true),
                arguments(3, -2, 0, true),
                arguments(-1, 1, 0, true),
                arguments(10, 15, 25, false));
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		
        TestDemo mockDemo = spy(testDemo);
        doReturn(5).when(mockDemo).getRandomInt();

        int fiveSquared = mockDemo.randomNumberSquared();

        assertThat(fiveSquared).isEqualTo(25);
        
 
	}
	
	
	
	

}
