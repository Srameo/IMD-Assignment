# Flutter

> <font color='red'>This is just like a md mirror of the [Website](https://flutter.dev) !</font>

> [Flutter](https://flutter.dev) is Google’s UI toolkit for building beautiful, natively compiled applications for [mobile](https://flutter.dev/docs), [web](https://flutter.dev/web), and [desktop](https://flutter.dev/desktop) from a single codebase.

- [Flutter](#flutter)
  - [Three Main Characteristics](#three-main-characteristics)
    - [Fast Development](#fast-development)
    - [Expressive and Flexible UI](#expressive-and-flexible-ui)
    - [Native Performance](#native-performance)
  - [Try Flutter in your browser](#try-flutter-in-your-browser)
  - [Fast development](#fast-development-1)
  - [Expressive, beautiful UIs](#expressive-beautiful-uis)
    - [Reflectly](#reflectly)
  - [Native Performance](#native-performance-1)

## Three Main Characteristics

### Fast Development

Paint your app to life in milliseconds with Stateful Hot Reload. Use a rich set of fully-customizable widgets to build native interfaces in minutes.

### Expressive and Flexible UI

Quickly ship features with a focus on native end-user experiences. Layered architecture allows for full customization, which results in incredibly fast rendering and expressive and flexible designs.

### Native Performance

Flutter’s widgets incorporate all critical platform differences such as scrolling, navigation, icons and fonts, and your Flutter code is compiled to native ARM machine code using [Dart's native compilers](https://dart.dev/platforms).

## Try Flutter in your browser

> You can try the Flutter in the [official website](https://flutter.dev)

<strong>1. Spinning Flutter</strong>

```dart
import 'package:flutter/material.dart';

void main() async {
  runApp(
    MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        body: MyApp(),
      ),
    ),
  );
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp>
    with SingleTickerProviderStateMixin {
  AnimationController controller;
  Animation<double> animation;

  @override
  void initState() {
    super.initState();

    controller = AnimationController(
      duration: Duration(seconds: 1),
      vsync: this,
    );

    animation = CurvedAnimation(
      parent: controller,
      curve: Curves.easeInOutCubic,
    ).drive(Tween(begin: 0, end: 2));
  }

  @override
  void dispose() {
    controller.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () {
        controller
          ..reset()
          ..forward();
      },
      child: RotationTransition(
        turns: animation,
        child: Stack(
          children: [
            Positioned.fill(
              child: FlutterLogo(),
            ),
            Center(
              child: Text(
                'Click me!',
                style: TextStyle(
                  fontSize: 60.0,
                  fontWeight: FontWeight.bold,
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
```

With the code above, you can create a ui like this.

![](../../asset/Lab1/flutter/spinning_flutter.jpg)

you can click the icon, then the flutter icon can spinning!

<strong>2. U can try other examples in the [official website](https://flutter.dev)</strong>

## Fast development

Flutter's *hot reload* helps you quickly and easily experiment, build UIs, add features, and fix bugs faster. Experience sub-second reload times without losing state on emulators, simulators, and hardware.

[More details in here!](https://flutter.dev/docs/development/tools/hot-reload)

<video src="https://flutter.dev/videos/FastDev.mp4" title="Hot reload demo"></video>

## Expressive, beautiful UIs

Delight your users with Flutter's built-in beautiful Material Design and Cupertino (iOS-flavor) widgets, rich motion APIs, smooth natural scrolling, and platform awareness.

### Reflectly

An award winning mindfulness app built with Flutter.

<strong>Download</strong>: [iOS](https://itunes.apple.com/us/app/reflectly-mindfulness-journal/id1241229134), [Android](https://play.google.com/store/apps/details?id=com.reflectlyApp&e=-EnableAppDetailsPageRedesign)

[More details in here!](https://reflect.ly/)

<video src="https://flutter.dev/videos/Filters.mp4" title="Reflectly app demo"></video>

## Native Performance

Flutter’s widgets incorporate all critical platform differences such as scrolling, navigation, icons and fonts to provide full native performance on both iOS and Android.

[Examples](https://flutter.dev/showcase)

<video src="https://flutter.dev/videos/NativePerformance.mp4" title="Demo showcasing animations and transition performance"></video>

