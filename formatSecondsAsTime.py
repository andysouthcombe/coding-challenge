from staticData import Parameters


def format_seconds_to_time(seconds):
    minutes, seconds = divmod(seconds, 60)
    hours, final_minutes = divmod(minutes, 60)
    return "%02d:%02d:%02d" % (hours, final_minutes, seconds)
