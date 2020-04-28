def validate_cube(cube_to_validate):
    if len(cube_to_validate) != 6:
        raise ValueError("incorrect number of sides")

    for face in cube_to_validate:
        if len(face) < 9:
            raise ValueError("incorrect number of blocks")
