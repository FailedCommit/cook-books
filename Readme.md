### Protobuf Starter Guide

Protobuf Plugin for Gradle - https://github.com/google/protobuf-gradle-plugin

Youtube video - https://youtu.be/CDYoLQR6744

I am getting error running HelloPersonProto.java which is the main class.

error: package PersonOuterClass does not exist
PersonOuterClass.Person person = PersonOuterClass.Person.newBuilder()

Fix:

Hack - 
Copying the generated file to the same package as main file or copying main file out to the same folder as generated file fixes this problem.
But a better solution would be to generate files in a dedicated folder and be able to use them from various files in different packages.

Proper Fix -








