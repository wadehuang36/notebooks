import math
from unittest import TestCase

tc = TestCase()

def eq(expect, actual):
    tc.assertEqual(expect, actual)
    
def log(string, *params):
    print(string.format(*params))