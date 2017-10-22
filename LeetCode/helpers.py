import math
import json
import time
from unittest import TestCase

tc = TestCase()

def eq(expect, actual):
    tc.assertEqual(expect, actual)
    
def two_d_eq(expect, actual):
    try:
        tc.assertEqual(len(expect), len(actual))
    
        for i in range(len(expect)):
            tc.assertListEqual(expect[i], actual[i])
    except (AssertionError, Exception):
        raise ValueError("Acturl is " + json.dumps(actual))

def start_watch():
    return time.time()
    
def stop_watch(start):
     return time.time() - start
    
def log(string, *params):
    print(string.format(*params))