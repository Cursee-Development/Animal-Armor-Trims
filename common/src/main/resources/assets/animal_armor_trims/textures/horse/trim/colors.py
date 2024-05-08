from PIL import Image
import os

# 0 - 9

index = 9
minerals = ["amethyst", "copper", "diamond", "emerald", "gold", "iron", "lapis", "netherite", "quartz", "redstone"]

def replace_colors(image_path, palette_path):
    # Load the image
    img = Image.open(image_path).convert("RGBA")

    # Load the palette image
    palette_img = Image.open(palette_path).convert("RGBA")
    palette_pixels = palette_img.getdata()

    # Extract the 8 colors from the palette image
    palette = list(set(palette_pixels))
    palette = palette[:8]  # We only need the first 8 unique colors

    # Map each color in the original image to the closest color in the palette
    new_img = Image.new("RGBA", img.size)
    pixels = img.getdata()
    new_pixels = []
    for pixel in pixels:
        if pixel[3] != 0:  # Ignore transparent pixels
            closest_color = min(palette, key=lambda c: sum((a-b)**2 for a, b in zip(pixel[:3], c[:3])))
            new_pixels.append(closest_color)
        else:
            new_pixels.append(pixel)

    # Replace the pixels in the new image
    new_img.putdata(new_pixels)

    # Save the new image
    new_img.save(image_path.replace("models_old", "models_new").replace(".png", "_" + minerals[index] + ".png"))

# Path to the folder containing PNG images
folder_path = "models_old"

# Path to the palette image
palette_path = "color_palettes/" + minerals[index] + ".png"

# Iterate over every PNG image in the folder
for filename in os.listdir(folder_path):
    if filename.endswith(".png"):
        image_path = os.path.join(folder_path, filename)
        replace_colors(image_path, palette_path)

print("Color replacement complete!")
print(minerals[index])
