import time

def fibonacci (n):
    if n<=1:
        return n
    return fibonacci(n-1) + fibonacci(n-2)

def fibonacci_caching (n, cache = None):
    if cache is None:
        cache = {}
    if n<=1:
        return n
    if n in cache:
        return cache [n]
    result = fibonacci_caching(n-1, cache) + fibonacci_caching(n-2, cache)
    return result
    
def main():
    print("Programación Dinámica")
    
    start_time = time.time_ns()
    print(fibonacci(20))
    end_time = time.time_ns()
    print(f"Time taken: {end_time - start_time} ns")
    
    start_time = time.time_ns()
    print(fibonacci_caching(20))
    end_time = time.time_ns()
    print(f"Time taken: {end_time - start_time} ns")

if __name__ == "__main__":
    main()