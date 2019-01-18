# MaterialLoadingButton

A **configurable** and **animated** material loading button.

## Usage

Minimum SDK: 21 

### Gradle
```
allprojects {
  repositories {
    maven { url 'https://jitpack.io' }
  }
}
```
```
dependencies {
	implementation 'com.github.Muki1992:MaterialLoadingButton:Tag'
 }
```
### XML
```xml
        <de.mustafagercek.library.LoadingButton
                android:id="@+id/loading_button"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                app:buttonText="Do stuff"
                app:onButtonClick="@{(view)->presenter.doStuff(view)}"
                bind:buttonColor="@{@color/colorPrimary}"/>

## License


Copyright 2019 Mustafa Gercek

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
