from staticData import Parameters


def format_seconds_to_time(seconds):
    minutes, seconds = divmod(seconds, 60)

    return "00:%02d:%02d" % (minutes,seconds)
