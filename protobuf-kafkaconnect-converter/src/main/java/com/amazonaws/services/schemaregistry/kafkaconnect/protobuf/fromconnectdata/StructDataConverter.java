package com.amazonaws.services.schemaregistry.kafkaconnect.protobuf.fromconnectdata;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Message;
import org.apache.kafka.connect.data.Schema;

public class StructDataConverter implements DataConverter {
    @Override
    public void toProtobufData(final Descriptors.FileDescriptor fileDescriptor, final Schema schema,
                               final Object value, final Descriptors.FieldDescriptor fieldDescriptor,
                               final Message.Builder messageBuilder) {
        messageBuilder.setField(fieldDescriptor, toProtobufData(fileDescriptor, schema, value, fieldDescriptor));
    }

    @Override
    public Object toProtobufData(final Descriptors.FileDescriptor fileDescriptor, final Schema schema,
                                 final Object value, final Descriptors.FieldDescriptor fieldDescriptor) {
        Message message = new ConnectDataToProtobufDataConverter().convert(fileDescriptor, schema, value);
        return message;
    }
}