package com.amazonaws.services.schemaregistry.kafkaconnect.protobuf;

import com.amazonaws.services.schemaregistry.kafkaconnect.tests.syntax2.ArrayTypeSyntax2;
import com.amazonaws.services.schemaregistry.kafkaconnect.tests.syntax2.MapTypeSyntax2;
import com.amazonaws.services.schemaregistry.kafkaconnect.tests.syntax2.NestedTypeSyntax2;
import com.amazonaws.services.schemaregistry.kafkaconnect.tests.syntax2.OneofTypeSyntax2;
import com.amazonaws.services.schemaregistry.kafkaconnect.tests.syntax2.PrimitiveTypesSyntax2;
import com.amazonaws.services.schemaregistry.kafkaconnect.tests.syntax3.ArrayTypeSyntax3;
import com.amazonaws.services.schemaregistry.kafkaconnect.tests.syntax3.MapTypeSyntax3;
import com.amazonaws.services.schemaregistry.kafkaconnect.tests.syntax3.NestedTypeSyntax3;
import com.amazonaws.services.schemaregistry.kafkaconnect.tests.syntax3.OneofTypeSyntax3;
import com.amazonaws.services.schemaregistry.kafkaconnect.tests.syntax3.PrimitiveTypesSyntax3;
import com.amazonaws.services.schemaregistry.kafkaconnect.tests.syntax2.EnumTypeSyntax2;
import com.amazonaws.services.schemaregistry.kafkaconnect.tests.syntax3.EnumTypeSyntax3;
import com.amazonaws.services.schemaregistry.kafkaconnect.tests.syntax2.TimeTypeSyntax2;
import com.amazonaws.services.schemaregistry.kafkaconnect.tests.syntax3.TimeTypeSyntax3;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.ByteString;
import com.google.protobuf.Message;
import org.apache.kafka.connect.data.Date;
import org.apache.kafka.connect.data.Time;
import org.apache.kafka.connect.data.Timestamp;
import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.data.SchemaBuilder;
import org.apache.kafka.connect.data.Struct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.amazonaws.services.schemaregistry.kafkaconnect.protobuf.CommonTestHelper.createConnectSchema;
import static com.amazonaws.services.schemaregistry.kafkaconnect.protobuf.fromconnectschema.ProtobufSchemaConverterConstants.PROTOBUF_PACKAGE;
import static com.amazonaws.services.schemaregistry.kafkaconnect.protobuf.fromconnectschema.ProtobufSchemaConverterConstants.PROTOBUF_TAG;
import static com.amazonaws.services.schemaregistry.kafkaconnect.protobuf.fromconnectschema.ProtobufSchemaConverterConstants.PROTOBUF_TYPE;

public class ToConnectTestDataGenerator {

    public static List<Message> getPrimitiveProtobufMessages() {
        return Arrays.asList(
            PrimitiveTypesSyntax3.PrimitiveTypes.newBuilder()
                .setI8(2)
                .setI8WithParam(0)
                .clearI8Optional()
                .setI8WithDefault(10)
                .setI16(255)
                .setI16WithParam(234)
                .setI16WithDefault(15)
                .setI16Optional(87)
                .setI32(123123)
                .setI32WithParam(23982)
                .setI32WithSameTypeMetadata(2345)
                .setI32WithMetadata(-1829)
                .setI32WithAnotherMetadata(123)
                .setI32WithDefault(0)
                .clearI32Optional()
                .setI64(-23499L)
                .setI64WithParam(7659L)
                .setI64WithDefault(1238102931L)
                .setI64WithSameTypeMetadata(8294L)
                .setI64WithMetadata(9123L)
                .setI64WithAnotherMetadata(8272L)
                .setI64WithYetAnotherMetadata(80123)
                .setI64Optional(91010L)
                .setF32(34.56F)
                .setF32WithParam(89.00F)
                .setF32Optional(81232.1234566F)
                .setF32WithDefault(2456F)
                .setF64(9123D)
                .setF64WithParam(91202.213D)
                .setF64Optional(-927.456D)
                .setF64WithDefault(0.0023D)
                .setBool(true)
                .setBoolWithParam(true)
                .clearBoolOptional()
                .setBoolWithDefault(false)
                .setBytes(ByteString.copyFrom(new byte[] { 1, 5, 6, 7 }))
                .setBytesWithParam(ByteString.copyFrom(new byte[] { 1 }))
                .clearBytesOptional()
                .setBytesWithDefault(ByteString.copyFrom(new byte[] { 1, 4, 5, 6 }))
                .setStr("asdsai131")
                .setStrWithParam("12351")
                .clearStrOptional()
                .setStrWithDefault("")
                .build(),
            PrimitiveTypesSyntax2.PrimitiveTypes.newBuilder()
                .setI8(2)
                .setI8WithParam(0)
                .clearI8Optional()
                .setI8WithDefault(10)
                .setI16(255)
                .setI16WithParam(234)
                .setI16WithDefault(15)
                .setI16Optional(87)
                .setI32(123123)
                .setI32WithParam(23982)
                .setI32WithSameTypeMetadata(2345)
                .setI32WithMetadata(-1829)
                .setI32WithAnotherMetadata(123)
                .setI32WithDefault(0)
                .clearI32Optional()
                .setI64(-23499L)
                .setI64WithParam(7659L)
                .setI64WithDefault(1238102931L)
                .setI64WithSameTypeMetadata(8294L)
                .setI64WithMetadata(9123L)
                .setI64WithAnotherMetadata(8272L)
                .setI64WithYetAnotherMetadata(80123)
                .setI64Optional(91010L)
                .setF32(34.56F)
                .setF32WithParam(89.00F)
                .setF32Optional(81232.1234566F)
                .setF32WithDefault(2456F)
                .setF64(9123D)
                .setF64WithParam(91202.213D)
                .setF64Optional(-927.456D)
                .setF64WithDefault(0.0023D)
                .setBool(true)
                .setBoolWithParam(true)
                .clearBoolOptional()
                .setBoolWithDefault(false)
                .setBytes(ByteString.copyFrom(new byte[] { 1, 5, 6, 7 }))
                .setBytesWithParam(ByteString.copyFrom(new byte[] { 1 }))
                .clearBytesOptional()
                .setBytesWithDefault(ByteString.copyFrom(new byte[] { 1, 4, 5, 6 }))
                .setStr("asdsai131")
                .setStrWithParam("12351")
                .clearStrOptional()
                .setStrWithDefault("")
                .build()
        );
    }

    public static Schema getPrimitiveSchema(String packageName) {
        return createConnectSchema(
            "PrimitiveTypes",
            getPrimitiveTypes(),
            ImmutableMap.of(PROTOBUF_PACKAGE, packageName)
        );
    }

    public static Struct getPrimitiveTypesData(String packageName) {
        final Struct connectData = new Struct(getPrimitiveSchema(packageName));

        connectData
            //TODO: Temporarily override INT8,16 to INT32 till we support storing metadata in Protobuf schemas.
            //            .put("i8", (byte) 2)
            .put("i8", 2)
            //            .put("i8WithParam", (byte) 0)
            .put("i8WithParam", 0)
            .put("i8Optional", null)
            //            .put("i8WithDefault", (byte) 10)
            .put("i8WithDefault", 10)
            //            .put("i16", (short) 255)
            .put("i16", 255)
            //            .put("i16WithParam", (short) 234)
            //            .put("i16WithDefault", (short) 15)
            //            .put("i16Optional", (short) 87)
            //End override
            .put("i16WithParam", 234)
            .put("i16WithDefault", 15)
            .put("i16Optional", 87)
            .put("i32", 123123)
            .put("i32WithParam", 23982)
            .put("i32WithSameTypeMetadata", 2345)
            .put("i32WithMetadata", -1829)
            .put("i32WithAnotherMetadata", 123)
            .put("i32WithDefault", 0)
            .put("i32Optional", null)
            .put("i64", -23499L)
            .put("i64WithParam", 7659L)
            .put("i64WithDefault", 1238102931L)
            .put("i64WithSameTypeMetadata", 8294L)
            .put("i64WithMetadata", 9123L)
            .put("i64WithAnotherMetadata", 8272L)
            .put("i64WithYetAnotherMetadata", 80123L)
            .put("i64Optional", 91010L)
            .put("f32", 34.56F)
            .put("f32WithParam", 89.00F)
            .put("f32Optional", 81232.1234566F)
            .put("f32WithDefault", 2456F)
            .put("f64", 9123D)
            .put("f64WithParam", 91202.213D)
            .put("f64Optional", -927.456D)
            .put("f64WithDefault", 0.0023D)
            .put("bool", true)
            .put("boolWithParam", true)
            .put("boolOptional", null)
            .put("boolWithDefault", false)
            .put("bytes", new byte[] { 1, 5, 6, 7 })
            .put("bytesWithParam", new byte[] { 1 })
            .put("bytesOptional", null)
            .put("bytesWithDefault", new byte[] { 1, 4, 5, 6 })
            .put("str", "asdsai131")
            .put("strWithParam", "12351")
            .put("strOptional", null)
            .put("strWithDefault", "");
        return connectData;
    }

    private static Map<String, Schema> getPrimitiveTypes() {
        return ImmutableMap.<String, Schema>builder()
            //TODO: Temporarily override INT8,16 to INT32 till we support storing metadata in Protobuf schemas.
            .put("i8", new SchemaBuilder(Schema.Type.INT32).parameter(PROTOBUF_TAG, "1").build())
            .put("i8WithParam", new SchemaBuilder(Schema.Type.INT32).parameter(PROTOBUF_TAG, "2000").build())
            .put("i8Optional", new SchemaBuilder(Schema.Type.INT32).optional().parameter(PROTOBUF_TAG, "2").build())
            .put("i8WithDefault", new SchemaBuilder(Schema.Type.INT32).parameter(PROTOBUF_TAG, "3").build())
            .put("i16", new SchemaBuilder(Schema.Type.INT32).parameter(PROTOBUF_TAG, "4").build())
            .put("i16WithParam", new SchemaBuilder(Schema.Type.INT32).parameter(PROTOBUF_TAG, "4123").build())
            .put("i16WithDefault", new SchemaBuilder(Schema.Type.INT32).parameter(PROTOBUF_TAG, "5").build())
            .put("i16Optional", new SchemaBuilder(Schema.Type.INT32).parameter(PROTOBUF_TAG, "6").optional().build())
            //End temporary override of INT8 INT 16 to INT 32

            .put("i32", new SchemaBuilder(Schema.Type.INT32).parameter(PROTOBUF_TAG, "7").build())
            .put("i32WithParam", new SchemaBuilder(Schema.Type.INT32).parameter(PROTOBUF_TAG, "8123").build())
            .put("i32WithSameTypeMetadata",
                new SchemaBuilder(Schema.Type.INT32).parameter(PROTOBUF_TAG, "8").build())
            .put("i32WithMetadata",
                new SchemaBuilder(Schema.Type.INT32).parameter(PROTOBUF_TAG, "9").parameter(PROTOBUF_TYPE, "SINT32")
                    .build())
            .put("i32WithAnotherMetadata",
                new SchemaBuilder(Schema.Type.INT32).parameter(PROTOBUF_TAG, "10").parameter(PROTOBUF_TYPE, "SFIXED32")
                    .build())
            .put("i32WithDefault", new SchemaBuilder(Schema.Type.INT32).parameter(PROTOBUF_TAG, "11").build())
            .put("i32Optional", new SchemaBuilder(Schema.Type.INT32).parameter(PROTOBUF_TAG, "12").optional().build())
            .put("i64", new SchemaBuilder(Schema.Type.INT64).parameter(PROTOBUF_TAG, "13").build())
            .put("i64WithParam", new SchemaBuilder(Schema.Type.INT64).parameter(PROTOBUF_TAG, "9123").build())
            .put("i64WithDefault", new SchemaBuilder(Schema.Type.INT64).parameter(PROTOBUF_TAG, "14").build())
            .put("i64WithSameTypeMetadata",
                new SchemaBuilder(Schema.Type.INT64).parameter(PROTOBUF_TAG, "15").build())
            .put("i64WithMetadata",
                new SchemaBuilder(Schema.Type.INT64).parameter(PROTOBUF_TAG, "16").parameter(PROTOBUF_TYPE, "SINT64")
                    .build())
            .put("i64WithAnotherMetadata",
                new SchemaBuilder(Schema.Type.INT64).parameter(PROTOBUF_TAG, "17").parameter(PROTOBUF_TYPE, "FIXED64")
                    .build())
            .put("i64WithYetAnotherMetadata",
                new SchemaBuilder(Schema.Type.INT64).parameter(PROTOBUF_TAG, "18").parameter(PROTOBUF_TYPE, "UINT32")
                    .build())
            .put("i64Optional", new SchemaBuilder(Schema.Type.INT64).parameter(PROTOBUF_TAG, "19").optional().build())
            .put("f32", new SchemaBuilder(Schema.Type.FLOAT32).parameter(PROTOBUF_TAG, "20").build())
            .put("f32WithParam", new SchemaBuilder(Schema.Type.FLOAT32).parameter(PROTOBUF_TAG, "10923").build())
            .put("f32Optional", new SchemaBuilder(Schema.Type.FLOAT32).parameter(PROTOBUF_TAG, "21").optional().build())
            .put("f32WithDefault", new SchemaBuilder(Schema.Type.FLOAT32).parameter(PROTOBUF_TAG, "22").build())
            .put("f64", new SchemaBuilder(Schema.Type.FLOAT64).parameter(PROTOBUF_TAG, "23").build())
            .put("f64WithParam", new SchemaBuilder(Schema.Type.FLOAT64).parameter(PROTOBUF_TAG, "1112").build())
            .put("f64Optional", new SchemaBuilder(Schema.Type.FLOAT64).parameter(PROTOBUF_TAG, "24").optional().build())
            .put("f64WithDefault", new SchemaBuilder(Schema.Type.FLOAT64).parameter(PROTOBUF_TAG, "25").build())
            .put("bool", new SchemaBuilder(Schema.Type.BOOLEAN).parameter(PROTOBUF_TAG, "26").build())
            .put("boolWithParam", new SchemaBuilder(Schema.Type.BOOLEAN).parameter(PROTOBUF_TAG, "12123").build())
            .put("boolOptional",
                new SchemaBuilder(Schema.Type.BOOLEAN).parameter(PROTOBUF_TAG, "27").optional().build())
            .put("boolWithDefault", new SchemaBuilder(Schema.Type.BOOLEAN).parameter(PROTOBUF_TAG, "28").build())
            .put("bytes", new SchemaBuilder(Schema.Type.BYTES).parameter(PROTOBUF_TAG, "29").build())
            .put("bytesWithParam", new SchemaBuilder(Schema.Type.BYTES).parameter(PROTOBUF_TAG, "18924").build())
            .put("bytesOptional", new SchemaBuilder(Schema.Type.BYTES).parameter(PROTOBUF_TAG, "30").optional().build())
            .put("bytesWithDefault",
                new SchemaBuilder(Schema.Type.BYTES).parameter(PROTOBUF_TAG, "31").build())
            .put("str", new SchemaBuilder(Schema.Type.STRING).parameter(PROTOBUF_TAG, "32").build())
            .put("strWithParam", new SchemaBuilder(Schema.Type.STRING).parameter(PROTOBUF_TAG, "13912").build())
            .put("strOptional", new SchemaBuilder(Schema.Type.STRING).parameter(PROTOBUF_TAG, "33").optional().build())
            .put("strWithDefault", new SchemaBuilder(Schema.Type.STRING).parameter(PROTOBUF_TAG, "34").build())
            .build();
    }

    public static List<Message> getEnumProtobufMessages() {
        return Arrays.asList(
                EnumTypeSyntax3.EnumTest.newBuilder()
                        .setCorpus(EnumTypeSyntax3.EnumTest.Corpus.UNIVERSAL)
                        .setShapes(EnumTypeSyntax3.EnumTest.ShapesWithParam.TRIANGLE)
                        .setColor(EnumTypeSyntax3.EnumTest.Colors.BLUE)
                        .setFruits(EnumTypeSyntax3.EnumTest.FruitsWithDefault.BANANA)
                        .build(),
                EnumTypeSyntax2.EnumTest.newBuilder()
                        .setCorpus(EnumTypeSyntax2.EnumTest.Corpus.UNIVERSAL)
                        .setShapes(EnumTypeSyntax2.EnumTest.ShapesWithParam.TRIANGLE)
                        .setColor(EnumTypeSyntax2.EnumTest.Colors.BLUE)
                        .setFruits(EnumTypeSyntax2.EnumTest.FruitsWithDefault.BANANA)
                        .build()
        );
    }

    public static Schema getEnumSchema(String packageName) {
        return createConnectSchema(
                "EnumTest",
                getEnumType(),
                ImmutableMap.of(
                        "protobuf.package", packageName
                )
        );
    }

    public static Struct getEnumTypeData(String packageName) {
        final Struct connectData = new Struct(getEnumSchema(packageName));

        connectData
                .put("corpus", "UNIVERSAL")
                .put("shapes", "TRIANGLE")
                .put( "color", "BLUE")
                .put("fruits", "BANANA");
        return connectData;
    }

    private static Map<String, Schema> getEnumType() {
        return ImmutableMap.<String, Schema>builder()
                .put("corpus", new SchemaBuilder(Schema.Type.STRING)
                        .parameter("protobuf.type", "enum")
                        .parameter("PROTOBUF_ENUM_VALUE.UNIVERSAL", "0")
                        .parameter("PROTOBUF_ENUM_VALUE.WEB", "1")
                        .parameter("PROTOBUF_ENUM_VALUE.NEWS", "4")
                        .parameter("PROTOBUF_ENUM_VALUE.IMAGES", "2")
                        .parameter("PROTOBUF_ENUM_VALUE.LOCAL", "3")
                        .parameter("PROTOBUF_ENUM_VALUE.PRODUCTS", "5")
                        .parameter("PROTOBUF_ENUM_VALUE.VIDEO", "6")
                        .parameter("ENUM_NAME", "Corpus")
                        .parameter("protobuf.tag", "1")
                        .build())
                .put("shapes", new SchemaBuilder(Schema.Type.STRING)
                        .parameter("protobuf.type", "enum")
                        .parameter("PROTOBUF_ENUM_VALUE.SQUARE", "0")
                        .parameter("PROTOBUF_ENUM_VALUE.CIRCLE", "1")
                        .parameter("PROTOBUF_ENUM_VALUE.TRIANGLE", "2")
                        .parameter("ENUM_NAME", "ShapesWithParam")
                        .parameter("protobuf.tag", "12345")
                        .build())
                .put("color", new SchemaBuilder(Schema.Type.STRING)
                        .parameter("protobuf.type", "enum")
                        .parameter("PROTOBUF_ENUM_VALUE.BLACK", "0")
                        .parameter("PROTOBUF_ENUM_VALUE.RED", "1")
                        .parameter("PROTOBUF_ENUM_VALUE.GREEN", "2")
                        .parameter("PROTOBUF_ENUM_VALUE.BLUE", "3")
                        .parameter("ENUM_NAME", "Colors")
                        .parameter("protobuf.tag", "2")
                        .optional()
                        .build())
                .put("fruits", new SchemaBuilder(Schema.Type.STRING)
                        .parameter("protobuf.type", "enum")
                        .parameter("PROTOBUF_ENUM_VALUE.APPLE", "0")
                        .parameter("PROTOBUF_ENUM_VALUE.ORANGE", "1")
                        .parameter("PROTOBUF_ENUM_VALUE.BANANA", "2")
                        .parameter("ENUM_NAME", "FruitsWithDefault")
                        .parameter("protobuf.tag", "3")
                        .build())
                .build();
    }

    public static List<Message> getTimeProtobufMessages() {
        com.google.type.Date.Builder dateBuilder = com.google.type.Date.newBuilder();
        dateBuilder.setYear(2022);
        dateBuilder.setMonth(3);
        dateBuilder.setDay(20);

        com.google.type.TimeOfDay.Builder todBuilder = com.google.type.TimeOfDay.newBuilder();
        todBuilder.setHours(2);
        todBuilder.setMinutes(2);
        todBuilder.setSeconds(42);

        com.google.protobuf.Timestamp.Builder timestampBuilder = com.google.protobuf.Timestamp.newBuilder();
        timestampBuilder.setSeconds(1);
        timestampBuilder.setNanos(805000000);
        return Arrays.asList(
                TimeTypeSyntax3.TimeTypes.newBuilder()
                        .setDate(dateBuilder)
                        .setTime(todBuilder)
                        .setTimestamp(timestampBuilder)
                        .build(),
                TimeTypeSyntax2.TimeTypes.newBuilder()
                        .setDate(dateBuilder)
                        .setTime(todBuilder)
                        .setTimestamp(timestampBuilder)
                        .build()
        );
    }


    public static Schema getTimeSchema(String packageName) {
        return createConnectSchema(
                "TimeTypes",
                getTimeTypes(),
                ImmutableMap.of(
                        "protobuf.package", packageName
                )
        );
    }

    public static Struct getTimeTypeData(String packageName) {
        final Struct connectData = new Struct(getTimeSchema(packageName));
        int dateDefVal = 19071; // equal to 2022/03/20 with reference to the unix epoch
        int timeDefVal = 7362000; // equal to 2 hours 2 minutes 42 seconds in millisecond
        long tsDefVal = 1805; // equal to 1 second 805000000 nanoseconds in millisecond
        java.util.Date date = Date.toLogical(Date.SCHEMA, dateDefVal);
        java.util.Date time = Time.toLogical(Time.SCHEMA, timeDefVal);
        java.util.Date timestamp = Timestamp.toLogical(Timestamp.SCHEMA, tsDefVal);

        connectData
                .put("date", date)
                .put("time", time)
                .put("timestamp", timestamp);
        return connectData;
    }

    private static Map<String, Schema> getTimeTypes() {
        return ImmutableMap.<String, Schema>builder()
                .put("date", Date.builder().parameter(PROTOBUF_TAG,"1").build())
                .put("time", Time.builder().parameter(PROTOBUF_TAG,"2").build())
                .put("timestamp", Timestamp.builder().parameter(PROTOBUF_TAG,"3").build())
                .build();
    }

    public static List<Message> getArrayProtobufMessages() {
        return Arrays.asList(
            ArrayTypeSyntax3.ArrayType.newBuilder()
                .addAllStr(Arrays.asList("foo", "bar", "baz"))
                .addBoolean(true)
                .addBoolean(false)
                .build(),
            ArrayTypeSyntax2.ArrayType.newBuilder()
                .addAllStr(Arrays.asList("foo", "bar", "baz"))
                .addBoolean(true)
                .addBoolean(false)
                .build()
        );
    }

    public static Schema getArraySchema(String packageName) {
        return createConnectSchema(
            "ArrayType",
            getArrayType(),
            ImmutableMap.of(PROTOBUF_PACKAGE, packageName)
        );
    }

    public static Struct getArrayTypeData(String packageName) {
        final Struct connectData = new Struct(getArraySchema(packageName));

        connectData
            .put("str", Arrays.asList("foo", "bar", "baz"))
            .put("boolean", Arrays.asList(true, false))
            .put("i32", new ArrayList<>());
        return connectData;
    }

    private static Map<String, Schema> getArrayType() {
        return ImmutableMap.<String, Schema>builder()
            .put("str", SchemaBuilder.array(Schema.STRING_SCHEMA).parameter(PROTOBUF_TAG, "1").optional().build())
            .put("i32", SchemaBuilder.array(Schema.INT32_SCHEMA).parameter(PROTOBUF_TAG, "2").optional().build())
            .put("boolean", SchemaBuilder.array(Schema.BOOLEAN_SCHEMA).parameter(PROTOBUF_TAG, "3").optional().build())
            .build();
    }

    public static List<Message> getMapProtobufMessages() {
        Map<String, Boolean> booleanMap = new HashMap<>();
        booleanMap.put("A", true);
        booleanMap.put("B", false);
        return Arrays.asList(
            MapTypeSyntax3.MapType.newBuilder()
                .putIntMap(2, 22)
                .putAllBoolMap(booleanMap)
                .build(),
            MapTypeSyntax2.MapType.newBuilder()
                .putIntMap(2, 22)
                .putAllBoolMap(booleanMap)
                .build()
        );
    }

    public static Schema getMapSchema(String packageName) {
        return createConnectSchema(
            "MapType",
            getMapType(),
            ImmutableMap.of(PROTOBUF_PACKAGE, packageName)
        );
    }

    public static Struct getMapTypeData(String packageName) {
        final Struct connectData = new Struct(getMapSchema(packageName));

        connectData
            .put("intMap", ImmutableMap.of(2, 22))
            .put("boolMap", ImmutableMap.of("A", true, "B", false))
            .put("strMap", new HashMap<>());
        return connectData;
    }

    private static Map<String, Schema> getMapType() {
        return ImmutableMap.<String, Schema>builder()
            .put("intMap", SchemaBuilder.map(
                new SchemaBuilder(Schema.Type.INT32).parameter(PROTOBUF_TAG, "1").optional().build(),
                new SchemaBuilder(Schema.Type.INT32).parameter(PROTOBUF_TAG, "2").optional().build())
                .parameter(PROTOBUF_TAG, "1").build())
            .put("boolMap", SchemaBuilder.map(
                new SchemaBuilder(Schema.Type.STRING).parameter(PROTOBUF_TAG, "1").optional().build(),
                new SchemaBuilder(Schema.Type.BOOLEAN).parameter(PROTOBUF_TAG, "2").optional().build())
                .parameter(PROTOBUF_TAG, "2").build())
            .put("strMap", SchemaBuilder.map(
                new SchemaBuilder(Schema.Type.INT32).parameter(PROTOBUF_TAG, "1").optional().build(),
                new SchemaBuilder(Schema.Type.STRING).parameter(PROTOBUF_TAG, "2").optional().build())
                .parameter(PROTOBUF_TAG, "3").build())
            .build();
    }

    public static List<Message> getStructProtobufMessages() {
        NestedTypeSyntax2.Address addressSyntax2 =
                NestedTypeSyntax2.Address.newBuilder().setStreet("8th").setZipcode(98121).build();
        NestedTypeSyntax2.NestedType.Customer customerSyntax2 =
                NestedTypeSyntax2.NestedType.Customer.newBuilder().setName("joe").build();
        NestedTypeSyntax2.NestedType nestedTypeSyntax2 =
                NestedTypeSyntax2.NestedType.newBuilder()
                        .setAddress(addressSyntax2)
                        .setCustomer(customerSyntax2)
                        .setStatus(NestedTypeSyntax2.Status.VALID)
                        .setId(12365)
                        .putMapping("hello", true).build();
        NestedTypeSyntax3.Address addressSyntax3 =
                NestedTypeSyntax3.Address.newBuilder().setStreet("8th").setZipcode(98121).build();
        NestedTypeSyntax3.NestedType.Customer customerSyntax3 =
                NestedTypeSyntax3.NestedType.Customer.newBuilder().setName("joe").build();
        NestedTypeSyntax3.NestedType nestedTypeSyntax3 =
                NestedTypeSyntax3.NestedType.newBuilder()
                        .setAddress(addressSyntax3)
                        .setCustomer(customerSyntax3)
                        .setStatus(NestedTypeSyntax3.Status.VALID)
                        .setId(12365)
                        .putMapping("hello", true).build();
        return Arrays.asList(nestedTypeSyntax3, nestedTypeSyntax2);
    }

    public static Schema getStructSchema(String packageName) {
        return createConnectSchema(
                "NestedType",
                getStructType(packageName),
                ImmutableMap.of(PROTOBUF_PACKAGE, packageName)
        );
    }

    public static Struct getStructTypeData(String packageName) {
        final Schema connectSchema = getStructSchema(packageName);
        final Struct connectData = new Struct(connectSchema);

        connectData
                .put("address", new Struct(connectSchema.field("address").schema()).put("street", "8th").put("zipcode", 98121))
                .put("status", "VALID")
                .put("customer", new Struct(connectSchema.field("customer").schema()).put("name", "joe"))
                .put("mapping", ImmutableMap.of("hello", true))
                .put("id", 12365);
        return connectData;
    }

    private static Map<String, Schema> getStructType(String packageName) {
        final SchemaBuilder addressBuilder =
                SchemaBuilder.struct().name(getStructTypeFullName(packageName, "Address"))
                        .field("street", SchemaBuilder.string().parameter(PROTOBUF_TAG, "1").build())
                        .field("zipcode", SchemaBuilder.int32().parameter(PROTOBUF_TAG, "2").build());
        final SchemaBuilder statusBuilder = new SchemaBuilder(Schema.Type.STRING)
                .parameter("protobuf.type", "enum")
                .parameter("PROTOBUF_ENUM_VALUE.VALID", "0")
                .parameter("PROTOBUF_ENUM_VALUE.INVALID", "1")
                .parameter("ENUM_NAME", "Status");
        final SchemaBuilder customerBuilder =
                SchemaBuilder.struct().name(getStructTypeFullName(packageName, "NestedType.Customer"))
                        .field("name", SchemaBuilder.string().parameter(PROTOBUF_TAG, "1").build());
        final SchemaBuilder mappingBuilder = SchemaBuilder.map(
                new SchemaBuilder(Schema.Type.STRING).parameter(PROTOBUF_TAG, "1").optional().build(),
                new SchemaBuilder(Schema.Type.BOOLEAN).parameter(PROTOBUF_TAG, "2").optional().build());


        return ImmutableMap.<String, Schema>builder()
                .put("address", addressBuilder.parameter(PROTOBUF_TAG, "1").build())
                .put("status", statusBuilder.parameter(PROTOBUF_TAG, "2").build())
                .put("customer", customerBuilder.parameter(PROTOBUF_TAG, "3").build())
                .put("mapping", mappingBuilder.parameter(PROTOBUF_TAG, "4").build())
                .put("id", SchemaBuilder.int32().parameter(PROTOBUF_TAG, "5").optional().build())
                .build();
    }

    private static String getStructTypeFullName(String packageName, String name) {
        return String.join(".", packageName, name);
    }

    public static List<Message> getOneofProtobufMessages() {
        return Arrays.asList(
                OneofTypeSyntax3.OneofType.newBuilder()
                        .setName("Jeff")
                        .setShipped(true)
                        .build(),
                OneofTypeSyntax2.OneofType.newBuilder()
                        .setName("Jeff")
                        .setShipped(true)
                        .build()
        );
    }

    public static Schema getOneofSchema(String packageName) {
        return createConnectSchema(
                "OneofType",
                getOneofType(),
                ImmutableMap.of(PROTOBUF_PACKAGE, packageName)
        );
    }

    public static Struct getOneofTypeData(String packageName) {
        final Struct connectData = new Struct(getOneofSchema(packageName));
        final Schema connectSchema = getOneofSchema(packageName);

        connectData
                .put("customer", new Struct(connectSchema.field("customer").schema()).put("name", "Jeff"))
                .put("order", new Struct(connectSchema.field("order").schema()).put("shipped", true));
        return connectData;
    }

    private static Map<String, Schema> getOneofType() {
        return ImmutableMap.<String, Schema>builder()
                .put("customer", SchemaBuilder.struct()
                        .name("customer")
                        .field("name", SchemaBuilder.string().parameter(PROTOBUF_TAG, "5").optional().build())
                        .field("age", SchemaBuilder.int32().parameter(PROTOBUF_TAG, "6").optional().build())
                        .parameter("protobuf.type", "oneof")
                        .optional().build())
                .put("order", SchemaBuilder.struct()
                        .name("order")
                        .field("id", SchemaBuilder.int32().parameter(PROTOBUF_TAG, "1").optional().build())
                        .field("shipped", SchemaBuilder.bool().parameter(PROTOBUF_TAG, "2").optional().build())
                        .parameter("protobuf.type", "oneof")
                        .optional().build())
                .build();
    }
}