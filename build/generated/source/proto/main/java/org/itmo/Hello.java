// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: hello.proto

package org.itmo;

public final class Hello {
  private Hello() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_org_itmo_HelloRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_org_itmo_HelloRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_org_itmo_HelloResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_org_itmo_HelloResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\013hello.proto\022\010org.itmo\"3\n\014HelloRequest\022" +
      "\021\n\tfirstName\030\001 \001(\t\022\020\n\010lastName\030\002 \001(\t\"!\n\r" +
      "HelloResponse\022\020\n\010greeting\030\001 \001(\t2L\n\014Hello" +
      "Service\022<\n\005hello\022\026.org.itmo.HelloRequest" +
      "\032\027.org.itmo.HelloResponse(\0010\001B\002P\001b\006proto" +
      "3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_org_itmo_HelloRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_org_itmo_HelloRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_org_itmo_HelloRequest_descriptor,
        new java.lang.String[] { "FirstName", "LastName", });
    internal_static_org_itmo_HelloResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_org_itmo_HelloResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_org_itmo_HelloResponse_descriptor,
        new java.lang.String[] { "Greeting", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
