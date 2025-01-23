## Proxy Design Pattern

The Proxy Design Pattern provides a surrogate or placeholder for another object to control access to it. This pattern is used to create a representative object that controls access to another object, which may be remote, expensive to create, or in need of securing.

### Main Use Cases of Proxy Design Pattern

1. **Access Restriction**: Control access to the original object, allowing only authorized clients to invoke methods on it.
2. **Caching**: Store the results of expensive operations and reuse them when the same inputs occur again, improving performance.
3. **Preprocessing or Postprocessing**: Perform additional operations before or after invoking methods on the original object.

### Additional Use Cases

- **Marshalling and Unmarshalling**: Convert objects to a format suitable for transmission over a network and then back to their original form by creating a chain of proxies.