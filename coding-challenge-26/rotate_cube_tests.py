import unittest
from rotate_cube import validate_cube

correct_cube_input = ["GGGGGGGGG", "YYYYYYYYY", "OOOOOOOOO", "RRRRRRRRR", "WWWWWWWWW", "BBBBBBBBB"]

class ValidateCubeTests(unittest.TestCase):
    def test_validate_cube_throws_exception_if_not_enough_sides(self):
        self.assertRaises(ValueError, validate_cube, ["GGGGGGGGG", "YYYYYYYYY", "OOOOOOOOO", "RRRRRRRR", "WWWWWWWWWWW"])

    def test_validate_cube_throws_exception_if_any_face_has_less_than_nine_blocks(self):
        self.assertRaises(ValueError, validate_cube,
                          ["GGGGGGGGG", "YYYYYYYYY", "OOOOOOOOO", "RRRRRRR", "WWWWWWWWWWW", "BBBBBBBBB"])

    def test_validate_cube_throws_exception_if_any_face_has_more_than_nine_blocks(self):
        self.assertRaises(ValueError, validate_cube,
                          ["GGGGGGGGG", "YYYYYYYYY", "OOOOOOOOO", "RRRRRRRRR", "WWWWWWWWWWW", "BBBBBBBBB"])

    def test_validate_cube_throws_exception_if_any_colour_does_not_have_nine_blocks(self):
        self.assertRaises(ValueError, validate_cube,
                          ["GGGGGGGGG", "YYYYYYYYY", "OOOOOOOOO", "RRRRRRRRR", "WWWWWWWWW", "BBBBBBBB"])

    def test_validate_cube_passes_if_cube_is_valid(self):
        self.assertTrue(validate_cube(correct_cube_input))