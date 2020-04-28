def validate_cube(cube_to_validate):
    if len(cube_to_validate) != 6:
        raise ValueError("incorrect number of sides")

    for face in cube_to_validate:
        if len(face) != 9:
            raise ValueError("incorrect number of blocks")

    count_per_colour = [[x,cube_to_validate.count(x)] for x in set(cube_to_validate)]

    if any(colour_count != 9 for colour_count in count_per_colour):
        raise ValueError("incorrect number of blocks for colour")