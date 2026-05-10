# JNIDemo — Android JNI with C++

A demo Android app showing how to call native C++ code from Java using JNI (Java Native Interface).

## What it does

| Feature | Description |
|---|---|
| `helloFromJNI()` | Returns a string from C++ |
| `factorial(n)` | Computes factorial natively with overflow check |
| `reverseString(s)` | Reverses a Java string in C++ |
| `sumArray(int[])` | Sums an integer array in C++ |

## Stack

- **Language:** Java + C++17
- **Build:** CMake + Android NDK
- **Min SDK:** API 24
- **Logging:** Android Logcat (`JNI_DEMO` tag)

## Project structure

```
app/src/main/
├── cpp/
│   ├── CMakeLists.txt       # Native build config
│   └── native-lib.cpp       # C++ JNI functions
├── java/com/example/jnidemo/
│   └── MainActivity.java    # Java side, native declarations
└── res/layout/
    └── activity_main.xml    # UI layout
```

## Expected output

```
Hello from C++ via JNI !
Factoriel de 10 = 3628800
Texte inversé : !lufrewop si INJ
Somme du tableau = 150
```
<img width="620" height="443" alt="Screenshot 2026-05-10 135022" src="https://github.com/user-attachments/assets/55fa3872-0d70-4f8b-832a-c1b8d1cc8504" />


## Setup

1. Open in Android Studio
2. Make sure **NDK** and **CMake** are installed via SDK Manager
3. Run on emulator or physical device (API 24+)

## Key JNI concepts covered

- `extern "C"` to prevent C++ name mangling
- `JNIEnv*` as the gateway to JNI functions
- Type conversions: `jstring`, `jint`, `jintArray`
- Always release: `ReleaseStringUTFChars` / `ReleaseIntArrayElements`
- Load library: `System.loadLibrary("native-lib")`
