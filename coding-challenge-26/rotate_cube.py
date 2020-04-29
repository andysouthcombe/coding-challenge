face_position = {0: "front", 1: "back", 2: "left", 3: "right", 4: "top", 5: "bottom"}
adjacent_faces_to_shuffle = {
    "front": [("top", [6, 7, 8]), ("right", [0, 3, 6]), ("bottom", [2, 1, 0]), ("left", [2, 5, 8])],
    "back": ["top", "left", "bottom", "right"],
    "left": ["top", "front", "bottom", "back"],
    "right": ["top", "back", "bottom", "front"],
    "top": [("back", [0, 1, 2]), ("right", [0, 1, 2]), ("front", [0, 1, 2]), ("left", [0, 1, 2])],
    "bottom": ["front", "right", "back", "left"]
}


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

    def get_face_by_position_name(self, face_to_get):
        return [f for f in self.faces if f.position == face_to_get][0]


def rotate_cube(cube_string, face_to_rotate, direction):
    if validate_cube(cube_string):
        start_cube = Cube(cube_string)
        new_faces = []
        faces_to_shuffle = adjacent_faces_to_shuffle[face_to_rotate]

        for face in start_cube.faces:
            if face.position == face_to_rotate:
                matrix = [face.blocks[0:3], face.blocks[3:6], face.blocks[6:]]

                if direction == "cw":
                    rotated_matrix = list(zip(*matrix[::-1]))
                else:
                    rotated_matrix = list(map(list, zip(*matrix)))[::-1]
                rotated_face_list = [j for i in rotated_matrix for j in i]
                new_faces.append(Face(face.position, "".join(rotated_face_list)))
            elif any(f[0] == face.position for f in faces_to_shuffle):
                new_faces.append(get_shuffled_face(start_cube, face_to_rotate, face.position, direction))
            else:
                new_faces.append(face)

    return [f.print_face_as_string() for f in new_faces]


def get_blocks_to_shuffle_to_and_from(face_to_rotate, face_to_shuffle, direction):
    if direction == "ccw":
        shuffle_order = adjacent_faces_to_shuffle[face_to_rotate]
    else:
        shuffle_order = list(reversed(adjacent_faces_to_shuffle[face_to_rotate]))

    for index, face in enumerate(shuffle_order):
        if face[0] == face_to_shuffle:
            return face, shuffle_order[(index + 1) % 4]


def get_shuffled_face(start_cube, face_to_rotate, face_to_shuffle, direction):
    face_blocks_to, face_blocks_from = get_blocks_to_shuffle_to_and_from(face_to_rotate, face_to_shuffle, direction)
    starting_face = start_cube.get_face_by_position_name(face_blocks_to[0])
    shuffle_from_face = start_cube.get_face_by_position_name(face_blocks_from[0])
    output_face = starting_face

    for index, block in enumerate(face_blocks_to[1]):
        output_face.blocks[block] = shuffle_from_face.blocks[index]

    return output_face


if __name__ == "__main__":
    start_cube = Cube(["GGGGGGGGY", "YYYYYYYYG", "OOOOOOOOO", "RRRRRRRRR", "WWWWWWWWW", "BBBBBBBBB"])
    print(rotate_cube(["GGGGGGGGY", "YYYYYYYYG", "OOOOOOOOO", "RRRRRRRRR", "WWWWWWWWW", "BBBBBBBBB"],"top","cw"))
    print(get_shuffled_face(start_cube, "front", "top", "cw").print_face_as_string())
