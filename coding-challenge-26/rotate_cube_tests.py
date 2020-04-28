import unittest
from rotate_cube import validate_cube


class ValidateCubeTests(unittest.TestCase):
    def test_validate_cube_throws_exception_if_not_enough_sides(self):
        self.assertRaises(ValueError, validate_cube, ["GGGGGGGGG","YYYYYYYYY","OOOOOOOOO","RRRRRRRR","WWWWWWWWWWW"])
