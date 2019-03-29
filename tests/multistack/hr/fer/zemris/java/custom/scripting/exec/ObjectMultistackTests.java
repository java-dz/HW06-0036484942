package hr.fer.zemris.java.custom.scripting.exec;
import static org.junit.Assert.*;

import org.junit.Test;

import hr.fer.zemris.java.custom.scripting.exec.ObjectMultistack;
import hr.fer.zemris.java.custom.scripting.exec.ValueWrapper;

@SuppressWarnings("javadoc")
public class ObjectMultistackTests {

    @Test
    public void testPushNullValue() {
        ObjectMultistack multistack = new ObjectMultistack();

        multistack.push("null", new ValueWrapper(null));
        ValueWrapper wrapper = multistack.peek("null");
        wrapper.increment(0); // neutral increment

        // value should be turned into 0 upon retrieval
        assertEquals(Integer.valueOf(0), wrapper.getValue());
    }

    @Test
    public void testPushNullKey() {
        ObjectMultistack multistack = new ObjectMultistack();

        multistack.push(null, new ValueWrapper(5));
        multistack.push(null, new ValueWrapper("12"));
        multistack.push(null, new ValueWrapper(7.5));
        multistack.push(null, new ValueWrapper("1E2"));

        Object value = multistack.pop(null).getValue();
        assertEquals("1E2", value);

        value = multistack.pop(null).getValue();
        assertEquals(7.5, value);

        value = multistack.pop(null).getValue();
        assertEquals("12", value);

        value = multistack.pop(null).getValue();
        assertEquals(5, value);
    }

    @Test
    public void testPop() {
        ObjectMultistack multistack = getStack();

        Object value = multistack.pop("year").getValue();

        // value should be 2000 upon retrieval
        assertEquals(2000, value);
    }

    @Test(expected=EmptyStackException.class)
    public void testPopEmpty() {
        ObjectMultistack multistack = new ObjectMultistack();
        // must throw
        multistack.pop("empty");
    }

    @Test
    public void testPeek() {
        ObjectMultistack multistack = new ObjectMultistack();
        multistack.push("year", new ValueWrapper("250"));

        Object value = multistack.peek("year").getValue();

        // value should be the last pushed value
        assertEquals("250", value);
        assertEquals(false, multistack.isEmpty("year"));
    }


    @Test
    public void testIncrement() {
        ObjectMultistack multistack = getStack();
        multistack.push("year", new ValueWrapper("500"));

        ValueWrapper wrapper = multistack.peek("year");
        wrapper.increment(1480);
        wrapper.increment(45.7);

        Object actual = wrapper.getValue();

        assertEquals(new Double(2025.7), actual);
    }

    @Test
    public void testDecrement() {
        ObjectMultistack multistack = getStack();
        multistack.push("year", new ValueWrapper(null));

        ValueWrapper value = multistack.peek("year");
        value.decrement(100);
        value.decrement(-123.5);

        Object actual = value.getValue();

        assertEquals(new Double(23.5), actual);
    }

    @Test
    public void testMultiply() {
        ObjectMultistack multistack = getStack();
        multistack.push("year", new ValueWrapper("1000"));

        ValueWrapper value = multistack.peek("year");
        value.multiply(5);
        value.multiply(0.001);
        value.multiply(-2);

        Object actual = value.getValue();

        assertEquals(new Double(-10), actual);
    }

    @Test
    public void testDivide() {
        ObjectMultistack multistack = getStack();
        multistack.push("year", new ValueWrapper("1E5"));

        ValueWrapper value = multistack.peek("year");
        value.divide(10000);

        Object actual = value.getValue();

        assertEquals(new Double(10), actual);
    }

    @Test(expected=ArithmeticException.class)
    public void testDivideIntegerByZero() {
        ObjectMultistack multistack = new ObjectMultistack();
        multistack.push("zero", new ValueWrapper(13));

        ValueWrapper value = multistack.peek("zero");
        // must throw
        value.divide(0);
    }

    @Test(expected=ArithmeticException.class)
    public void testDivideDoubleByZero() {
        ObjectMultistack multistack = new ObjectMultistack();
        multistack.push("zero", new ValueWrapper(13.0));

        ValueWrapper value = multistack.peek("zero");
        // must throw
        value.divide(0.0);
    }

    @Test
    public void testDivideDoubleByValueCloseToZero() {
        ObjectMultistack multistack = new ObjectMultistack();
        multistack.push("close", new ValueWrapper("0.006"));

        ValueWrapper value = multistack.peek("close");
        value.divide(0.0000121);
    }

    @Test
    public void testNumCompare() {
        ObjectMultistack multistack = getStack();
        multistack.push("year", new ValueWrapper(20));

        String number = "1000";
        ValueWrapper value = multistack.peek("year");

        int compared = value.numCompare(number);

        assertEquals(-1, compared);
    }


    /**
     * Returns a multistack where there are two keys, "year" and "price", and
     * each of them have a value.
     */
    public static ObjectMultistack getStack() {
        ObjectMultistack multistack = new ObjectMultistack();

        ValueWrapper year = new ValueWrapper(Integer.valueOf(2000));
        multistack.push("year", year);

        ValueWrapper price = new ValueWrapper(200.51);
        multistack.push("price", price);

        return multistack;
    }
}
