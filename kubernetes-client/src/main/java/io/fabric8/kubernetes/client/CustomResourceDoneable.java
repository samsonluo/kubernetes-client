/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.builder.Function;
import io.fabric8.kubernetes.api.model.Doneable;

/**
 */
public class CustomResourceDoneable<T extends CustomResource> implements Doneable<T> {
  private final T resource;
  private final Function<T,T> function;

  public CustomResourceDoneable(T resource, Function<T,T> function) {
    this.resource = resource;
    this.function = function;
  }

  @Override
  public T done() {
    return function.apply(resource);
  }
}
