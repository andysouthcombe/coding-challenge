import unittest
from rotate_cube import *

cube_input_all_faces_one_colour = ["GGGGGGGGG", "YYYYYYYYY", "OOOOOOOOO", "RRRRRRRRR", "WWWWWWWWW", "BBBBBBBBB"]

cube_input_one_block_different_colour = ["GGGGGGGGY", "YYYYYYYYG", "OOOOOOOOO", "RRRRRRRRR", "WWWWWWWWW", "BBBBBBBBB"]

cube_input_multi_colours = ["GGGGGGGGG", "YYYYYYYYY", "OOOOOOWOO", "RRRRRRWRR", "WWRWOWBWW", "BBBBBBWBB"]


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
        self.assertTrue(validate_cube(cube_input_all_faces_one_colour))


class CubeTests(unittest.TestCase):
    def test_list_string_from_cube_returns_original_string(self):
        test_cube = Cube(cube_input_all_faces_one_colour)
        self.assertEqual(test_cube.list_cube_as_string(), cube_input_all_faces_one_colour)

    def test_get_face_by_position_name_returns_face(self):
        test_cube = Cube(cube_input_all_faces_one_colour)
        expected_face = Face("left", "OOOOOOOOO")
        self.assertEqual(expected_face.print_face_as_string(),
                         test_cube.get_face_by_position_name("left").print_face_as_string())


class TestGetBlocksToShuffleFromAndTo(unittest.TestCase):
    def test_get_blocks_to_shuffle_to_and_from_front_face_rotating_clockwise_shuffles_top_face(self):
        expected_pair = (("top", [6, 7, 8]), ("left", [6, 7, 8]))
        self.assertEqual(expected_pair, get_blocks_to_shuffle_to_and_from("front", "top", "cw"))

    def test_get_blocks_to_shuffle_to_and_from_front_face_rotating_clockwise_shuffles_left_face(self):
        expected_pair = (("left", [6, 7, 8]), ("bottom", [0, 1, 2]))
        self.assertEqual(expected_pair, get_blocks_to_shuffle_to_and_from("front", "left", "cw"))

    def test_get_blocks_to_shuffle_to_and_from_front_face_rotating_anti_clockwise_shuffles_left_face(self):
        expected_pair = (("left", [6, 7, 8]), ("top", [6, 7, 8]))
        self.assertEqual(expected_pair, get_blocks_to_shuffle_to_and_from("front", "left", "ccw"))




class RotateCubeTests(unittest.TestCase):
    def test_rotate_cube_returns_unchanged_front_face_when_all_blocks_the_same_colour_and_front_rotated(self):
        rotated_cube = rotate_cube(cube_input_all_faces_one_colour, "front", "cw")
        self.assertEqual("GGGGGGGGG", rotated_cube[0])

    def test_rotate_cube_rotates_front_face_clockwise_when_one_block_not_same_colour(self):
        rotated_cube = rotate_cube(cube_input_one_block_different_colour, "front", "cw")
        self.assertEqual("GGGGGGYGG", rotated_cube[0])

    def test_rotate_cube_rotates_top_face_anticlockwise(self):
        rotated_cube = rotate_cube(cube_input_multi_colours, "top", "ccw")
        self.assertEqual("RWWWOWWWB", rotated_cube[4])

    def test_rotate_cube_rotates_front_face_clockwise_and_shuffles_adjacent_sides(self):
        #expected_cube = ["GGGGGGYGG", "YYYYYYYYG", "OOOOOOOOO", "RRRRRRRRR", "WWWWWWWWW", "BBBBBBBBB"]
        expected_cube = ["GGGGGGYGG", "YYYYYYYYG", "OOOOOOBBB", "RRRRRRWWW", "WWWWWWOOO", "BBBBBBWWW"]
        rotated_cube = rotate_cube(cube_input_one_block_different_colour, "front", "cw")
        self.assertEqual(expected_cube,rotated_cube)
