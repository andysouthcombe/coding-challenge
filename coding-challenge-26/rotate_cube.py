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
        self.blocks = list(b)

    def print_face_as_string(self):
        return "".join(self.blocks)


class Cube:
    def __init__(self, cube_string):
        f = 0
        self.faces = []
        while f < 6:
            self.faces.append(Face(face_position[f], cube_string[f]))
            f += 1

    def list_cube_as_string(self):
        return [f.print_face_as_string() for f in self.faces]


def rotate_cube(cube_string, face_to_rotate, direction):
    if validate_cube(cube_string):
        start_cube = Cube(cube_string)
        new_faces = []
        for face in start_cube.faces:
            if face.position == face_to_rotate:
                matrix = [face.blocks[0:3], face.blocks[3:6], face.blocks[6:]]

                if direction == "cw":
                    rotated_matrix = list(zip(*matrix[::-1]))
                else:
                    rotated_matrix = list(map(list, zip(*matrix)))[::-1]
                rotated_face_list = [j for i in rotated_matrix for j in i]
                new_faces.append(Face(face.position, "".join(rotated_face_list)))
            else:
                new_faces.append(face)

    return [f.print_face_as_string() for f in new_faces]


if __name__ == "__main__":
    face = Face("top", "GYRGGGGGG")

    print(face.blocks[3:5])
