def validate_cube(cube_to_validate):
    if len(cube_to_validate) != 6:
        raise ValueError("incorrect number of sides")

    for face in cube_to_validate:
        if len(face) != 9:
            raise ValueError("incorrect number of blocks")

    cube_to_validate_string = "".join(cube_to_validate)
    count_per_colour = [[x, cube_to_validate_string.count(x)] for x in set(cube_to_validate_string)]

    if any(b != 9 for a,b in count_per_colour):
        raise ValueError("incorrect number of blocks for colour")

    return True
