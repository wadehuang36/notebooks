from unittest import TestCase

tc = TestCase()

def eq(expect, actual):
    tc.assertEqual(expect, actual)