/*
 * Copyright (C) 2015 Ivan Baranov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.ivbaranov.rxbluetooth;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Predicate;

public class Actions {
  /**
   * Creates a function, which checks if current action equals single action or one of many
   * actions. It can be used inside filter(...) method from RxJava.
   *
   * @param actions many actions or single action
   * @return Func1 checking function
   */
  public static <T> Predicate<T> isEqualTo(final T... actions) {
    return new Predicate<T>() {
      @Override
      public boolean test(@NonNull T t) throws Exception {
        for (T action : actions) {
          if (t.equals(action)) {
            return true;
          }
        }
        return false;
      }
    };
  }
}
