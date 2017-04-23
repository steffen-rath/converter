package de.rath.steffen.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class ConverterHierarchyTest {

    private static final String FROM_STRING = "to";
    private static final String ANOTHER_FROM_STRING = "another";
    private static final String YET_ANOTHER_FROM_STRING = "yet";
    private static final String FINAL_FROM_STRING = "final";

    @Test
    public void baseConverterWorks() {
        BaseFromClass from = new BaseFromClass();
        from.setFromString( FROM_STRING );
        BaseToClass to = new BaseConverter<BaseFromClass, BaseToClass>().convert( from );
        assertEquals( FROM_STRING, to.getToString() );
    }

    @Test
    public void baseConverterIsNullSafe() {
        BaseToClass output = new BaseConverter<BaseFromClass, BaseToClass>().convert( null );
        assertNull( output );
    }

    @Test
    public void baseConverterCanConvertCollections() {
        BaseFromClass firstFrom = new BaseFromClass();
        firstFrom.setFromString( FROM_STRING );
        BaseFromClass secondFrom = new BaseFromClass();
        secondFrom.setFromString( ANOTHER_FROM_STRING );
        List<BaseFromClass> froms = Arrays.asList( firstFrom, secondFrom );
        List<BaseToClass> tos = froms.stream().map( s -> new BaseConverter<BaseFromClass, BaseToClass>().convert( s ) )
                .collect( Collectors.toList() );
        assertEquals( FROM_STRING, tos.get( 0 ).getToString() );
        assertEquals( ANOTHER_FROM_STRING, tos.get( 1 ).getToString() );
    }

    @Test
    public void extendingConverterWorks() {
        ExtendingFromClass from = new ExtendingFromClass();
        from.setFromString( FROM_STRING );
        from.setAnotherFromString( ANOTHER_FROM_STRING );
        ExtendingToClass to = new ExtendingConverter<ExtendingFromClass, ExtendingToClass>().convert( from );
        assertEquals( FROM_STRING, to.getToString() );
        assertEquals( ANOTHER_FROM_STRING, to.getAnotherToString() );
    }

    @Test
    public void extendingConverterIsNullSafe() {
        ExtendingToClass to = new ExtendingConverter<ExtendingFromClass, ExtendingToClass>().convert( null );
        assertNull( to );
    }

    @Test
    public void extendingConverterCanConvertCollections() {
        ExtendingFromClass firstFrom = new ExtendingFromClass();
        firstFrom.setFromString( FROM_STRING );
        firstFrom.setAnotherFromString( ANOTHER_FROM_STRING );
        ExtendingFromClass secondFrom = new ExtendingFromClass();
        secondFrom.setFromString( YET_ANOTHER_FROM_STRING );
        secondFrom.setAnotherFromString( FINAL_FROM_STRING );
        List<ExtendingFromClass> froms = Arrays.asList( firstFrom, secondFrom );
        List<ExtendingToClass> tos = froms.stream()
                .map( s -> new ExtendingConverter<ExtendingFromClass, ExtendingToClass>().convert( s ) )
                .collect( Collectors.toList() );
        assertEquals( FROM_STRING, tos.get( 0 ).getToString() );
        assertEquals( ANOTHER_FROM_STRING, tos.get( 0 ).getAnotherToString() );
        assertEquals( YET_ANOTHER_FROM_STRING, tos.get( 1 ).getToString() );
        assertEquals( FINAL_FROM_STRING, tos.get( 1 ).getAnotherToString() );
    }
}
