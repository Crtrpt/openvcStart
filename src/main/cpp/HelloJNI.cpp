#include "HelloJNI.h"

JNIEXPORT void JNICALL Java_HelloJNI_sayHello (JNIEnv *, jobject){
    printf("Hello Jni ===============================================================\n");
    return;
}
