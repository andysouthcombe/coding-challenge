face_position = {0: "front", 1: "back", 2: "left", 3: "right", 4: "top", 5: "bottom"}


def validate_cube(cube_to_validate):
    if len(cube_to_validate) != 6:
        raise ValueError("incorrect number of sides")

    for face in cube_to_validate:
        if len(face) != 9:
            raise ValueError("incorrect number of blocks")

    cube_to_validate_string = "".join(cube_to_validate)
    count_per_colour = [[x, cube_to_validate_string.count(x)] for x in set(cube_to_validate_string)]

    if any(b != 9 for a, b in count_per_colour):
        raise ValueError("incorrect number of blocks for colour")

    return True


class Face:
    def __init__(self, p, b):
        self.position = p
        self.blocks = b.split()

    def print_face_as_string(self):
        return "".join(self.blocks)


class Cube:
    def __init__(self, cube_string):
        f = 0
        self.faces = []
        while f < 6:
            self.faces.append(Face([f], cube_string[f]))
            f += 1

    def list_cube_as_string(self):
        return [f.print_face_as_string() for f in self.faces]


def rotate_cube(cube_string,face_to_rotate,direction):
    start_cube = Cube(cube_string)
    return start_cube


if __name__ == "__main__":
    if validate_cube(["GGGGGGGGG", "YYYYYYYYY", "OOOOOOOOO", "RRRRRRRRR", "WWWWWWWWW", "BBBBBBBBB"]):
        test_cube = Cube(["GGGGGGGGG", "YYYYYYYYY", "OOOOOOOOO", "RRRRRRRRR", "WWWWWWWWW", "BBBBBBBBB"])

        print(test_cube.print_cube_as_string())
